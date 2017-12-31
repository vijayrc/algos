package com.vijayrc.algos.common

case class Value(i: Int) extends Ordered[Value] {
  def compare(that: Value) = this.i - that.i
  override def toString: String = i.toString
}
