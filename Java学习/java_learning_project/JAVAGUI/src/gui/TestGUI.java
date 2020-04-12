package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import charactor.Hero;
import jdbc.HeroDAO;

public class TestGUI {
    private static void setLookAndFeel() { //皮肤
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
            // handle exception
        }
    }

    static HeroTableModel htm = new HeroTableModel();
    static JTable t = new JTable(htm);

    // 把分页按钮放在这里，后面监听器好访问
    static JButton bFirst = new JButton("首页");
    static JButton bPre = new JButton("上一页");
    static JButton bNext = new JButton("下一页");
    static JButton bLast = new JButton("末页");
    static JComboBox<Integer> cb = new JComboBox<>();

    static int number = 10;// 每页显示10个
    static int start = 0;// 开始的页码
    private static boolean cbListenerEnabled = true;

    public static void main(String[] args) {
        //设置皮肤
        setLookAndFeel();
        final JFrame f = new JFrame("LoL");
        f.setSize(400, 340);
        f.setLocation(200, 200);

        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        t.getSelectionModel().setSelectionInterval(0, 0);

        JPanel pOperation = new JPanel();

        JButton bAdd = new JButton("增加");
        JButton bDelete = new JButton("删除");
        JButton bEdit = new JButton("编辑");
        pOperation.add(bAdd);
        pOperation.add(bDelete);
        pOperation.add(bEdit);

        JPanel pPage = new JPanel();

        pPage.add(bFirst);
        pPage.add(bPre);
        pPage.add(cb);

        pPage.add(bNext);
        pPage.add(bLast);

        bEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 判断是否选中
                int index = t.getSelectedRow();
                if (-1 == index) {
                    JOptionPane.showMessageDialog(f, "编辑前需要先选中一行");
                    return;
                }

                // 获取选中的对象
                Hero hero = htm.heros.get(index);

                // 显示编辑Dialog

                EditDialog ed = new EditDialog(f);
                ed.tfName.setText(hero.name);
                ed.tfHp.setText(String.valueOf((int) hero.hp));

                ed.setVisible(true);

            }
        });

        bAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDialog(f).setVisible(true);

                updateButtonStatus();
            }
        });
        bDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // 判断是否选中
                int index = t.getSelectedRow();
                if (-1 == index) {
                    JOptionPane.showMessageDialog(f, "删除前需要先选中一行");
                    return;
                }

                // 进行确认是否要删除
                if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(f, "确认要删除？"))
                    return;

                // 获取id
                Hero hero = htm.heros.get(index);
                int id = hero.id;

                // 删除
                new HeroDAO().delete(id);

                // 更新table
                start = 0;
                updateTable();
                updateButtonStatus();

            }
        });

        addPageListener();

        cb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!cbListenerEnabled)
                    return;

                int currentPage = (int) cb.getSelectedItem();
                start = (currentPage-1)*number;
                updateTable();
                updateButtonStatus();

            }
        });

        JScrollPane sp = new JScrollPane(t);

        f.setLayout(null);
        sp.setBounds(0, 0, 394, 200);
        pOperation.setBounds(0, 200, 394, 50);
        pPage.setBounds(0, 250, 394, 200);
        f.add(sp);
        f.add(pOperation);
        f.add(pPage);
        updateButtonStatus();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }

    private static void addPageListener() {

        bFirst.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                start = 0;
                updateTable();
                updateButtonStatus();
            }
        });
        bPre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                start -= number;
                updateTable();
                updateButtonStatus();
            }
        });
        bNext.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                start += number;
                updateTable();
                updateButtonStatus();
            }
        });
        bLast.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                start = last();

                updateTable();

                updateButtonStatus();

            }

        });

    }

    private static void updateButtonStatus() {
        int last = last();

        // 是否有上一页
        if (0 != start) {
            bFirst.setEnabled(true);
            bPre.setEnabled(true);
        }

        // 是否是第一页
        if (0 == start) {
            bFirst.setEnabled(false);
            bPre.setEnabled(false);
        }

        // 是否是最后一页
        if (start == last) {
            bLast.setEnabled(false);
            bNext.setEnabled(false);
        }
        // 是否有下一页
        if (start < last) {
            bLast.setEnabled(true);
            bNext.setEnabled(true);
        }

        //总共的页数
        int pageNumber =last/number+1;
        cbListenerEnabled = false;
        cb.removeAllItems();

        for (int i = 0; i < pageNumber; i++) {

            cb.addItem(i+1);
        }
        cbListenerEnabled = true;

        int currentPage = start/number +1;
        cb.setSelectedItem(currentPage);

    }

    static class AddDialog extends JDialog {
        JLabel lName = new JLabel("名称");
        JLabel lHp = new JLabel("血量");

        JTextField tfName = new JTextField();
        JTextField tfHp = new JTextField();

        JButton bSubmit = new JButton("提交");

        AddDialog(JFrame f) {
            super(f);
            this.setModal(true);
            int gap = 50;
            this.setLayout(null);

            JPanel pInput = new JPanel();
            JPanel pSubmit = new JPanel();

            pInput.setLayout(new GridLayout(2, 2, gap, gap));
            pInput.add(lName);
            pInput.add(tfName);
            pInput.add(lHp);
            pInput.add(tfHp);

            pSubmit.add(bSubmit);

            pInput.setBounds(50, 20, 200, 100);
            pSubmit.setBounds(0, 130, 300, 150);

            this.add(pInput);
            this.add(pSubmit);

            this.setSize(300, 200);
            this.setLocationRelativeTo(f);
            bSubmit.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    if (checkEmpty(tfName, "名称")) {
                        if (checkNumber(tfHp, "hp")) {

                            String name = tfName.getText();
                            int hp = Integer.parseInt(tfHp.getText());

                            Hero h = new Hero();
                            h.name = name;
                            h.hp = hp;

                            new HeroDAO().add(h);

                            JOptionPane.showMessageDialog(f, "提交成功 ");

                            AddDialog.this.setVisible(false);
                            start = 0;
                            updateTable();
                        }
                    }

                }
            });

        }
    }

    public static void updateTable() {
        htm.heros = new HeroDAO().list(start, number);
        t.updateUI();
        if (!htm.heros.isEmpty())
            t.getSelectionModel().setSelectionInterval(0, 0);
    }

    private static boolean checkEmpty(JTextField tf, String msg) {
        String value = tf.getText();
        if (0 == value.length()) {
            JOptionPane.showMessageDialog(null, msg + " 不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    private static boolean checkNumber(JTextField tf, String msg) {
        String value = tf.getText();
        if (0 == value.length()) {
            JOptionPane.showMessageDialog(null, msg + " 不能为空");
            tf.grabFocus();
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, msg + " 只能是整数");
            tf.grabFocus();
            return false;
        }

        return true;
    }

    static class EditDialog extends JDialog {
        JLabel lName = new JLabel("名称");
        JLabel lHp = new JLabel("血量");

        JTextField tfName = new JTextField();
        JTextField tfHp = new JTextField();

        JButton bSubmit = new JButton("提交");

        EditDialog(JFrame f) {
            super(f);
            this.setModal(true);
            int gap = 50;
            this.setLayout(null);

            JPanel pInput = new JPanel();
            JPanel pSubmit = new JPanel();

            pInput.setLayout(new GridLayout(2, 2, gap, gap));
            pInput.add(lName);
            pInput.add(tfName);
            pInput.add(lHp);
            pInput.add(tfHp);

            pSubmit.add(bSubmit);

            pInput.setBounds(50, 20, 200, 100);
            pSubmit.setBounds(0, 130, 300, 150);

            this.add(pInput);
            this.add(pSubmit);

            this.setSize(300, 200);
            this.setLocationRelativeTo(f);

            bSubmit.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (checkEmpty(tfName, "名称")) {
                        if (checkNumber(tfHp, "hp")) {

                            // 获取id
                            int index = t.getSelectedRow();
                            int id = htm.heros.get(index).id;

                            String name = tfName.getText();
                            int hp = Integer.parseInt(tfHp.getText());

                            Hero h = new Hero();
                            h.name = name;
                            h.hp = hp;
                            h.id = id;

                            new HeroDAO().update(h);

                            JOptionPane.showMessageDialog(f, "提交成功 ");

                            EditDialog.this.setVisible(false);
                            updateTable();
                        }
                    }

                }
            });
        }
    }

    private static int last() {
        // 最后一页开始的位置
        int last;

        int total = new HeroDAO().getTotal();

        // 最后一页要看总是是否能够整除每页显示的数量number

        if (0 == total % number) {
            // 假设总数是20，那么最后一页开始的位置就是10
            last = total - number;
        } else {
            // 假设总数是21，那么最后一页开始的位置就是20
            last = total - total % number;
        }
        return last;

    }
}