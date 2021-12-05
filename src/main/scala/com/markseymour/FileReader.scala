package com.markseymour

class FileReader {

def loadItems(): Map[String, CateringItem] = {
    var inventoryMap: Map[String, CateringItem] = Map[String, CateringItem]()
  val bufferedSource = io.Source.fromFile("src/test/resources/cateringsystem.csv")
  for(line <- bufferedSource.getLines()) {
    val columns = line.split("\\|").map(_.trim)
    val item: CateringItem = new CateringItem(columns(1), columns(2).toDouble, columns(0), columns(3))
    inventoryMap += (columns(0) -> item)
  }
  inventoryMap
  }

}
