#!/usr/bin/python
# -*- coding: utf-8 -*-
#encoding=utf-8
#Filename:assiic.py
#char(\d)与对应的assic码转换


import re

def i2c(strs):
	p=re.compile(' ')
	ss=p.split(strs)
	res=[];
	print(len(ss))
	for s in ss:
		if  s.isdigit():
			res.append(s)
	print(len(res))

	out=''
	for a in res:
		out=out+chr(int(a))
	print (out)
	
def c2i(strs):
	cell=''
	for s in strs:
		cell=cell+"Chr ( "+str(ord(s))+" )&"

	out=cell
	print (out)
	
	
	
#strs="Chr ( 104 ) & Chr ( 116 ) "
strs=raw_input("输入待转换字符串：\n")
if strs.find("Chr")>-1:
	i2c(strs)
else:
	c2i(strs)
