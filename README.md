# Compiler for miniJava

本项目是为miniJava语言构建的一个编译器前端，将输入的miniJava语言代码转化成抽象语法树（AST）

编译器前端包括以下功能

- 词法分析 Lexical Analysis 
- 句法分析 Parsing Analysis
- 语法分析 Semantic Analysis

最后输出一个抽象语法树AST，并且具有一定的错误提示和恢复能力。



## miniJava

miniJava Project 主页：http://www.cambridge.org/us/features/052182060X/

- 词法规则 Lexer rules：
  - 参考[MiniJavaReference Manual](http://www.cambridge.org/us/features/052182060X/mjreference/mjreference.html)中的Lexical Issues一节
- 句法规则 Parser rules：[BNF表示](http://www.cambridge.org/us/features/052182060X/grammar.html)
  - 参考[MiniJavaReference Manual](http://www.cambridge.org/us/features/052182060X/mjreference/mjreference.html)中的Grammer一节
  - 添加了comments的语法，并且允许简单的嵌套comments
- 抽象语法 Abstract Syntax
  - 根据miniJava主页上Abstract Syntax一部分，主要参考PrettyPrintVisitor.java中涉及到的抽象语法规则





## 运行平台

- 64位 windows 10
- Java 版本 1.8
- 开发环境为 IntelliJ



## 项目目录

```
Compiler
├── src				# 代码
│	├── examples 		# miniJava样例	
│	└── src/main/java	# 源代码
│		├── miniJava 		# 编译器java代码
│		│	├── antlr 				# 和antlr相关类及重载
│		│	│	├── gen 				# antlr4从g4文件中自动生成的java代码
│		│	│	│	└── ...			
│		│	│	├── ASTtree.java 				# AST结点以及遍历算法
│		│	│	├── MyErrorListener.java 		# 从antlr4中重载的错误处理
│		│	│	├── MyErrorStrategy.java 		# 从antlr4中重载的错误处理策略
│		│	│	├── MyminiJavaASTVisitor.java	# 从antlr4中重载的Visitor遍历
│		│	│	├── SymbolEntry.java 			# 符号表条目
│		│	│	└── SymTabScopeNode.java 		# 符号表
│		│	├── LISPtoTree.java		 # 从LISP格式转化Tree的swing绘图代码
│		│	├── LISPtoTreeView.java  # 封装LISP的树可视化格式的类
│		│	└── Main.java			# 主程序
│		└── MyminiJava.g4	# miniJava语法文件
├── README.md		# README 		    
└── report.pdf		# 报告
```





## 运行方式

使用maven根据pom.xml配置好依赖环境之后，运行Main.java

Main.java的主函数main中filename决定了运行的minijava示例文件，使用runTemplate函数运行。



## 运行结果

首先会生成AST树，之后会进行语义检查，检查通过会输出"Pass Semantic Check!"字样

- 如果词法、句法检查不通过，将无法生成AST，并输出错误类型，出错位置，以及错误原因
- 如果语义检查不通过，将输出错误类型，出错位置以及错误原因，以供修改。



## 依赖说明

本项目使用maven配置依赖环境，依赖包在pom.xml中，包括

1. antlr4-runtime和antlr4，版本4.7.1。实现基本的语法和词法功能
2. [abego treelayout](http://treelayout.sourceforge.net/)，版本1.0.3。可视化树结构

