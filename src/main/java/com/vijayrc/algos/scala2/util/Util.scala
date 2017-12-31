package com.vijayrc.algos.scala2.util

import com.vijayrc.algos.scala2.sort.Value

object Util {
  def randomSet(sz:Int):Array[Value] = {
    val arr =  new Array[Value](sz)
    for(i <- 0 until sz) arr(i) = new Value((Math.random()*100).toInt)
    arr
  }

  def show(items: Array[Value]) {
    println(items.foreach(x => print(x + "|")))
  }
}
