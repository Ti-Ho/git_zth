#　Python学习/PythonWorkSpace/UserBasedCollaborativeFiltering/venv/Include/com/main.py
import math

userid = ""      # 找的目标用户

# 数据预处理
def load_data():
    f = open('u.data')
    user_list={}
    for line in f:
        (user,movie,rating,ts) = line.split('\t')
        user_list.setdefault(user,{})
        user_list[user][movie] = float(rating)
    return user_list

# 使用欧几里得距离:将两个人对同一部电影的评价相减平方再开平方
def calculate():
    list = load_data()
    user_diff = {}
    user = str(userid)
    for movies in list[user]:
        for people in list.keys():
            user_diff.setdefault(people, {})
            for item in list[people].keys():
                if item == movies:
                    diff = math.sqrt(pow(list[user][movies] - list[people][item], 2))
                    user_diff[people][item] = diff
    return user_diff

# 求距离平均值 -> 求相似度 = 1 / (1 + 距离平均值) 加1防止除0
# 相似度与距离成反比
def people_rating():
    user_diff = calculate()
    rating = {}
    for people in user_diff.keys():
        rating.setdefault(people, {})
        a = 0
        b = 0
        for score in user_diff[people].values():
            a += score
            b += 1
        rating[people] = float(1 / (1 + (a/b)))
    return rating

# 排序 找出几个相似度比较高的用户
def top_list():
    list = people_rating()
    items = list.items()   # 以列表返回可遍历的(键, 值) 元组数组
    top = [[v[1], v[0]] for v in items]
    top.sort(reverse = True)
    print(top[0:5]) # print出相似度最高的五个
    return top[0:5]

# 找出前两位最相似的用户看过但是userid用户没有看过的电影 并且评分为5的电影推荐给userid用户
def find_rec():
    rec_list = top_list()
    user1 = rec_list[1][1]
    user2 = rec_list[2][1]
    all_list = load_data()
    print("第一个用户推荐的电影:")
    for k, v in all_list[user1].items():
        if k not in all_list[str(userid)].keys() and v == 5:
            print(k)

    print("第二个用户推荐的电影:")
    for k, v in all_list[user2].items():
        if k not in all_list[str(userid)].keys() and v == 5:
            print(k)

# 主函数
userid = 7
find_rec()
