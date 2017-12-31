package com.vijayrc.algos.tree.binary

import org.scalatest.FunSuite
import com.vijayrc.algos.common.Value

class Tests extends FunSuite{
  test("should add to array at right places"){
    val tree = new NoLinks(10)
    for(x <- 1 until 10) tree.add(new Value(x))
    tree.show()
  }

}
