package catering

class Convenience {

  def toInvString(itemId: String, name: String, price: String, foodCat: String, stock: String): String = {
    "%-3s  %-20s  %-8s  %-10s  %-5s".format(itemId,name,price,foodCat,stock)

  }

}
