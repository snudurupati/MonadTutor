/**
 * Created by snudurupati on 10/22/15.
 * Examples defining the Monad laws
 *
 * First Law - Associativity
      m flatMap f flatMap g == m flatMap(x => f(x) flatMap g)
 *
 * Second Law - Left Unit
      unit(x) flatMap f == f(x)
 *
 * Third Law - Right Unit
      m flatMap unit == m
 */
object MonadLaws {
  def main(args: Array[String]) {

    //Example1
    val list = (1 to 5).toList

    //First Law - Associativity
    val res0 = list.flatMap(x => List(x*2)).flatMap(x => List(x/2))
    val res1 = list.flatMap(x => List(x*2).flatMap(x => List(x/2)))
    assert(res0 == res1)

    //Second Law - Left Unit
    val x = 2
    val res2 = List(x).flatMap(x => List(x*2))
    val res3 = List(x*2)
    assert(res2 == res3)

    //Third Law - Right Unit
    val res4 = list.flatMap(x => List(x))
    val res5 = list
    assert(res4 == res5)
  }

}
