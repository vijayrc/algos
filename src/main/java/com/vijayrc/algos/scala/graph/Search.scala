package com.vijayrc.algos.scala2.graph

import java.util

trait Search {
  def on(graph:Graph)
}
/**
 * Pick a node, then go through all its edges, then pick one of its peer nodes, repeat
 * the queue implementation (FIFO) makes sure you pick the neighbours first without diving deep
 */
class BreadthFirst extends Search{
  def on(graph:Graph){
    val queue = new java.util.LinkedList[Node]()
    val root: Node = graph.nodes(0)
    root.seen = true
    print(root.value +",")
    queue.add(root)

    while(!queue.isEmpty){
      val node = queue.remove()
      var child = node.unvisitedEdgeNode
      while(child != null){
        child.seen = true
        print(child.value +",")
        queue.add(child)
        child = node.unvisitedEdgeNode
      }
    }
  }
}
/**
 * pick a node n1,print its value, then pick one of its edge nodes n2, print,
 * then pick one edge-node of n2, like n3..repeat
 */
class DepthFirst extends Search{
  def on(graph:Graph){
    val stack = new util.Stack[Node]() //stack of visitedNodes
    val root: Node = graph.nodes(0)
    root.seen = true
    print(root.value +",")
    stack.push(root)

    while(!stack.isEmpty){
      val node = stack.peek()
      val child = node.unvisitedEdgeNode

      if(child != null){
        child.seen = true
        print(child.value +",")
        stack.push(child)
      }else{
        stack.pop() // all child nodes have been visited, so need to be in processing stack anymore
      }
    }
  }
}
