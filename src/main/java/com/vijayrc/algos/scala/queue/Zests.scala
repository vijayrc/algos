package com.vijayrc.algos.scala2.queue

import org.scalatest.FunSuite

class Zests extends FunSuite{

  test("should work for a link based queue"){
    val queue:Queue = new WithLinks
    for(i <- 1 to 5)queue.enqueue(i)
    for(i <- 1 to 2)queue.dequeue()
    queue.show()
  }
  test("should work for a array based queue"){
    val queue:Queue = new WithArray(1)
    for(i <- 1 to 5)queue.enqueue(i)
    for(i <- 1 to 4)queue.dequeue()
    queue.show()
  }

}
