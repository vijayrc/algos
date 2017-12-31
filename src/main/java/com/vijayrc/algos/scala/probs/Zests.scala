package com.vijayrc.algos.scala2.probs

import org.scalatest.FunSuite
import com.vijayrc.algos.scala2.util.Util
import com.vijayrc.algos.common.Value

class Zests extends FunSuite{
  test("should work"){
    val nthLargest = new NthLargest
    val nth = 3
    val set = Util.randomSet(10)
    val answer: Value = nthLargest.of(nth, set)
    println(Util.show(set)+", "+answer+" is "+(nth+1)+"th smallest")
  }
  test("should evaluate simple expressions"){
    val dijkstra = new TwoStack
    val evaluate: Int = dijkstra.evaluate("(((2*3)*(2+6))-(4*3))")
    assert(36 == evaluate)
  }
}
