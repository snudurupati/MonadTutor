/**
 * Created by snudurupati on 10/22/15.
 */
object OptionMonad {

  sealed trait Option[A] {
    def map[B](f: A => B): Option[B]
    def flatMap[B](f: A => Option[B]): Option[B]
  }

  case class Some[A](a: A) extends Option[A] {
    def map[B](f: A => B): Option[B] = new Some(f(a))
    def flatMap[B](f: A => Option[B]): Option[B] = f(a)
  }

  case class None[A]() extends Option[A] {
    def map[B](f: A => B): Option[B] = new None
    def flatMap[B](f: A => Option[B]): Option[B] = new None
  }

}
