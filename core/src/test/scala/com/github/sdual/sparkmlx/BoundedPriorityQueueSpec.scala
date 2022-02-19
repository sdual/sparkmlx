package com.github.sdual.sparkmlx

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class BoundedPriorityQueueSpec extends AnyWordSpec with Matchers {

  "BoundedPriorityQueue" should {
    "enqueue" in {
      val maxSize = 3
      val queue = new BoundedPriorityQueue[Int](maxSize)
      queue.enqueue(1)
      val actual = queue.first()
      val expected = 1

      actual should be(expected)
    }

    "dequeue" in {
      val maxSize = 3
      val queue = new BoundedPriorityQueue[Int](maxSize)
      queue.enqueue(1)
      val actual = queue.dequeue().get
      val expected = 1

      actual should be(expected)
      queue.size() should be(0)
    }

    "dequeue from empty queue" in {
      val maxSize = 3
      val queue = new BoundedPriorityQueue[Int](maxSize)
      val actual = queue.dequeue()

      actual shouldBe empty
    }

    "extract first" in {
      val maxSize = 3
      val queue = new BoundedPriorityQueue[Int](maxSize)
      queue.enqueue(2)
      val actual = queue.first()
      val expected = 2

      actual should be(expected)
      queue.size() should be(1)
    }

    "clear all elements" in {
      val maxSize = 3
      val queue = new BoundedPriorityQueue[Int](maxSize)
      queue.enqueue(2)
      queue.enqueue(3)

      queue.size() should be(2)

      queue.clear()

      queue.size() should be(0)
    }

    "replace lowest" in {
      val maxSize = 3
      val queue = new BoundedPriorityQueue[Int](maxSize)
      queue.enqueue(2)
      queue.enqueue(4)
      queue.enqueue(5)

      queue.first() should be(2)
      queue.size() should be(3)

      queue.enqueue(3)

      queue.first() should be(3)
      queue.size() should be(3)
    }

    "add all elements" in {
      val maxSize = 3
      val queue1 = new BoundedPriorityQueue[Int](maxSize)
      queue1.enqueue(2)
      queue1.enqueue(3)
      queue1.enqueue(5)

      val queue2 = new BoundedPriorityQueue[Int](maxSize)
      queue2.enqueue(4)
      queue2.enqueue(5)
      queue2.enqueue(6)

      queue1.addAll(queue2)

      val actual1 = queue1.dequeue().get
      val actual2 = queue1.dequeue().get
      val actual3 = queue1.dequeue().get

      actual1 should be(5)
      actual2 should be(5)
      actual3 should be(6)
    }

  }

}
