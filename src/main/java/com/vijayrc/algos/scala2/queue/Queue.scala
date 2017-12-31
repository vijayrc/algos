package com.vijayrc.algos.scala2.queue

trait Queue {
  def enqueue(item:Any):Queue
  def dequeue():Any
  def isEmpty:Boolean
  def show()
}
