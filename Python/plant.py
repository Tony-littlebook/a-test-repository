import numpy as np 
import math
import matplotlib as mpl 
import matplotlib.pyplot as plt 
"""
mpl.rcParams['font.sans-serif'] = [u'SimHei']
mpl.rcParams['axes.unicode_minus'] = False
mu = 0
sigma = 1
x = np.linspace(mu - 3*sigma, mu + 3*sigma, 51)
y = np.exp(-(x - mu) ** 2 / (2 * sigma **2)) / (math.sqrt(2 * math.pi) * sigma)
plt.figure(facecolor='w')
plt.plot(x, y, 'r-', x, y, 'go', linewidth = 2, markersize = 8)
plt.xlabel('X', fontsize = 15)
plt.ylabel('Y', fontsize = 15)
plt.title('Gauss Distribution', fontsize = 18)
plt.grid(True)
plt.show()

#损失函数
x = np.linspace(start = -2,stop = 3, num = 1001, dtype = np.float)
y_logit = np.log(1 + np.exp(-x)) / math.log(2)
y_boost = np.exp(-x)
y_01 = x < 0
y_hinge = 1.0 - x
y_hinge[y_hinge < 0] = 0
plt.figure(figsize = (10, 8))
plt.plot(x, y_logit, 'r-', label = 'Logistic Loss', linewidth = 2)
plt.plot(x, y_01, 'g-',label = '0/1 Loss', linewidth = 2)
plt.plot(x, y_hinge, 'b-', label = 'Hinge Loss', linewidth = 2)
plt.plot(x, y_boost, 'm--', label = 'Adaboost Loss', linewidth = 2)
plt.grid()
plt.legend(loc = 'upper right')
plt.show() 

def f(x):
    y = np.ones_like(x) #形状一样，用1填充
    i = x > 0
    y[i] = np.power(x[i], x[i])
    i = x < 0
    y[i] = np.power(-x[i], -x[i])
    return y

#x^x函数
x = np.linspace(-1.3, 1.3, 101)
y = f(x)
plt.plot(x, y, 'g-', label = 'x^x', linewidth = 2)
plt.grid()
plt.legend(loc = 'upper left')
plt.show()
"""

#sinx 函数
x = np.linspace(0, 10, 100)
y = np.sin(x)
plt.plot(x, y, 'g-', label = 'sinx', linewidth = 2)
plt.grid()
plt.legend(loc = 'upper right')
plt.show()