package com.vijayrc.algos.tree.binary

import com.vijayrc.algos.common.Value

/**
 * without pointers, use array arithmetic to store your tree.
 * tree is stored in a flat array
 */
class NoLinks(sz:Int) {
  private val arr = new Array[Value](sz)

  def add(input:Value){
    if(arr(0) == null) {arr(0) = input; return}
    recurse(input,0)
  }
  def recurse(input:Value,index:Int){
    var i = index
    if(i > arr.length) return
    if(arr(i) == null){
      arr(i) = input
    }else if(input < arr(i)){
      i += 2*i
      recurse(input,i)
    }else{
      i += 2*i+1
      recurse(input,i)
    }
  }
  def show(){
     arr.foreach(x => print(x+","))
  }
}
