package com.vijayrc.algos.scala2.probs

import com.vijayrc.algos.scala2.stack.{WithArray, Stack}
import org.scalatest.FunSuite

/**
 * dijkstra two stack to evaluate expressions
 */
class TwoStack {
  private val values:Stack = new WithArray(4)
  private val operators:Stack = new WithArray(4)

  def evaluate(expr:String):Int = {
    var flag = false //multi-digit numbers flag, is previous character digit
    expr.foreach(c =>
      if(isDigit(c)){
        if(flag) values.push(values.pop()+""+c)
        else values.push(c)
        flag = true
      }
      else if(isOperator(c)) {flag = false; operators.push(c)}
      else if(c == '(') flag = false
      else if(c == ')'){
        flag = false
        val a = values.pop()
        val b = values.pop()
        val op = operators.pop()
        values.push(doOps(a,b,op))
      }else println("unknown char: "+c)
    )
    values.pop().toString.toInt
  }

  private def doOps(a:Any, b:Any, op:Any):Int = {
    op match{
        case '*' => intOf(b) * intOf(a)
        case '+' => intOf(b) + intOf(a)
        case '-' => intOf(b) - intOf(a)
        case '/' => intOf(b) / intOf(a)
    }
  }
  private def isDigit(c: Char): Boolean = {
    var flag = false
    (0 to 9).foreach(i => if(c == i.toString.charAt(0)) flag = true)
    flag
  }
  private def isOperator(c: Char): Boolean = {
    var flag = false
    Array('*','+','/','-').foreach(i => if(c == i) flag = true)
    flag
  }
  private def intOf(any:Any):Int = {
    any.toString.toInt
  }
}

