package com.github.sdual.sparkmlx

import java.util.PriorityQueue
import scala.collection.JavaConverters._

class BoundedPriorityQueue[A <: Ordering[A]](maxSize: Int) extends Iterable[A] with Serializable {

  private val underlying: PriorityQueue[A] = new PriorityQueue[A]()

  def enqueue(element: A): Unit = {
    if (underlying.size() < maxSize) {
      underlying.offer(element)
    } else {
      replaceLowest(element)
    }
  }

  def dequeue(): A = {
    underlying.poll()
  }

  def clear(): Unit = {
    underlying.clear()
  }

  override def size(): Int = {
    underlying.size()
  }

  override def isEmpty: Boolean = {
    underlying.isEmpty
  }

  def addAll(queue: BoundedPriorityQueue[A]): Unit = {
    queue.foreach(this.enqueue)
  }

  private def replaceLowest(element: A): Unit = {
    for {
      headElement <- Option(underlying.peek())
      if headElement.gt(headElement, element)
      _ = underlying.poll()
      _ = underlying.offer(element)
    } yield ()
  }

  override def iterator: Iterator[A] = underlying.iterator.asScala
}

object BoundedPriorityQueue {
  def apply[A <: Ordering[A]](maxSize: Int): BoundedPriorityQueue[A] = {
    new BoundedPriorityQueue(maxSize)
  }
}

