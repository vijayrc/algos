package com.vijayrc.algos.scala2.queue

trait Queue {
  def enqueue(item:Any):Queue
  def dequeue():Any
  def isEmpty:Boolean
  def show()
}
/**
 * With array as a the backing mechanism with a initial size
 * double capacity whenever limits reached.
 * shrink by half, whenever the items occupy quarter capacity,
 * note the bandSz is the deciding factor
 */
class WithArray(val initialSz:Integer) extends Queue{
  private var arr = new Array[Any](initialSz)
  private var head = 0
  private var tail = 0
  def show() = arr.slice(head,tail).foreach(item => print(item +"|"))
  def isEmpty: Boolean = tail < 0

  def enqueue(item: Any): Queue = {
    if(bandSz == arr.length) grow()
    arr(tail) = item
    tail += 1
    this
  }
  def dequeue(): Any = {
    val item = arr(head)
    arr(head) = null
    head += 1
    if(bandSz <= arr.length/4) shrink()
    item
  }
  private def grow(){
    val newArr = new Array[Any](2*bandSz)
    var newIndex = 0
    arr.slice(head,tail).foreach(item =>
      if(item != null){
        newArr(newIndex) = item
        newIndex += 1
      }
    )
    arr = newArr; head = 0; tail = newIndex
  }
  private def shrink(){grow()}
  private def bandSz = tail - head
}
/**
 * With pointers to track head and tail
 * No need to worry about growth tracking
 */
class WithLinks extends Queue{
  var head:Node = null
  var tail:Node = null

  def enqueue(item: Any) = {
    if(head == null){head = new Node(item);tail = head
    }else{ val newTail = new Node(item); tail.next = newTail; tail  = newTail }
    this
  }
  def dequeue(): Any = {
    val item = head.item;head = head.next
    item
  }
  def show() {
    var cursor = head
    while(cursor != null){
      print(cursor.item+"|"); cursor = cursor.next;
    }
  }
  def isEmpty: Boolean = {head == null}
}
class Node(val item:Any){ var next:Node = null }
