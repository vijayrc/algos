package com.vijayrc.algos.scala2.stack

trait Stack {
    def push(item:Any):Stack
    def pop():Any
    def show()
}
/**
 * backed by an array
 * doubles in size when items reach half of its capacity
 * shrinks by half when items drop to quarter of its capacity
 */
class WithArray(val initialSz:Integer) extends Stack{
  var arr = new Array[Any](initialSz)
  var index = -1

  def push(item: Any): Stack = {
    index += 1
    if(index >= arr.length) grow()
    arr(index) = item
    this
  }
  def pop(): Any = {
    if(index < 0) return
    if(index != 0 && index <= (arr.length/4)) shrink()
    val value = arr(index)
    index -= 1
    value
  }
  def show(){
    arr.slice(0,index+1).foreach(a => print(a.toString+"|"))
    println()
  }
  private def grow() {
    val temp = new Array[Any](arr.length*2)
    arr copyToArray temp
    arr = temp
  }
  private def shrink(){
    val temp = new Array[Any](arr.length/2)
    arr copyToArray temp
    arr = temp
  }
}
/**
* just have a head node linking others
* no need to worry about growth hacking
*/
class WithLinks extends Stack{
  var head:Node = null

  def push(item:Any):WithLinks = {
    if(head == null) head = new Node(item,null)
    else head = new Node(item, head)
    this
  }
  def pop():Any = {
    if(head == null) { return null}
    val value = head.value
    head = head.next
    value
  }
  def show(){
    var temp = head
    while(temp != null){
      print(temp.print+"|")
      temp = temp.next
    }
  }
  class Node(val value:Any, val next:Node){
    def print = value.toString
  }
}

