package com.vijayrc.algos.scala2.probs

import com.vijayrc.algos.common.Value

/**
 * to find nth largest in a given set
 */
class NthLargest() {
  private var answer:Value = null

  def of(nth:Int,items:Array[Value]):Value = {
    recurse(items,0,items.size-1,nth)
    answer
  }
  def recurse(items:Array[Value],low:Int,high:Int,n:Int){
    if(low >= high || answer != null) return
    var l = low
    var r = high
    val partition = low
    while(l < r && l < items.size && r > 0){
      while(items(l)<items(partition)) l+=1
      while(items(r)>items(partition)) r-=1
      swap(l,r,items)
    }
    if(n < l){recurse(items,low,l-1,n)}
    else if(n > l){recurse(items,l+1,high,n)}
    else answer = items(l)
  }

  def swap(i: Int, j: Int, items: Array[Value]){
    val temp = items(i)
    items(i) = items(j)
    items(j) = temp
  }
}
