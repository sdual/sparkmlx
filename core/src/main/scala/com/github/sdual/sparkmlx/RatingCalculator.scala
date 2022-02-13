package com.github.sdual.sparkmlx

import org.apache.spark.ml.recommendation.ALSModel

class RatingCalculator(model: ALSModel) {

  def calculate(): Unit = {

  }

}

object RatingCalculator {
  def apply(model: ALSModel): RatingCalculator = {
    new RatingCalculator(model)
  }
}
