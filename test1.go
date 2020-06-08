// package main
//
// import "fmt"
//
// func main() {
//   var c1, c2,c3 chan int
//   var i1, i2 int
//   select {
//     case i1 = <-c1:
//       fmt.Printf("received ", i1, " from c2\n")
//     case c2 <- i2:
//       fmt.Printf("sent ", i2, " to c2\n")
//     case i3, ok := (<-c3):
//       if ok {
//         fmt.Printf("received ", i3, " from c3 \n")
//       } else {
//         fmt.Printf("c3 is closed\n")
//       }
//     default:
//       fmt.Printf("no communication\n")
//   }
// }
// package main
//
// import "fmt"
//
// func main() {
//   var b int = 15
//   var a int
//   numbers := [6]int{1,2,3,5}
//   for a := 0; a < 10; a++ {
//     fmt.Printf("a 的值为: %d\n", a)
//   }
//   for a < b {
//     a++
//     fmt.Printf("a 的值为： %d\n", a)
//   }
//   for i, x := range numbers {
//     fmt.Printf("第 %d 位 x 的值 = %d\n", i, x)
//   }
// }
// package main
//
// import "fmt"
//
// func main() {
//   var i, j int
//   for i=2; i < 100; i++ {
//     for j=2; j <= (i/j); j++ {
//       if(i%j == 0) {
//         break;
//       }
//     }
//     if(j > (i/j)) {
//       fmt.Printf("%d 是素数\n", i);
//     }
//   }
// }
// package main
//
// import "fmt"
//
// func main() {
//   var a int = 10
//   LOOP: for a < 20 {
//     if a == 15 {
//       a  = a + 1
//       goto LOOP
//     }
//     fmt.Printf("a value: %d\n", a)
//     a++
//   }
// }
func max(num1, num2, int) int {
  var result int
  if (num1 > num2) {
    result = num1
  } else {
    result = num2
  }
  return result
}

package main

import "fmt"

func main() {
  var a int = 100
  var b int = 200
  var ret int
  ret = max(a, b)
  fmt.Printf("max is: %d\n", ret)
}

package main

import "fmt"

func swap(x, y string) (string, string) {
  return y, x
}

func main() {
  a, b := swap("Mahesh", "Kumar")
  fmt.Printf(a, b)
}

func swap(x *int, y *int) {
  var temp int
  temp = *x
  *x = *y
  *y = temp
}

package main

import  (
  "fmt"
  "math"
)

func main() {
  getSquareRoot := func(x float64) float64 {
    return math.Sqrt(x)
  }
  fmt.Printf(getSquareRoot(9))
}

func getSequence() func() int {
  i := 0
  return func() int {
    i++
    return i
  }
}

package main

import "fmt"

func add(x1, x2 int) func()(int, int) {
  i := 0
  return func() (int, int) {
    i++
    return i, x1 + x2
  }
}
var balance [10] float32
var balance = [5]float32{100.0, 2.0, 3.4, 7.0, 50.0}
var balance = [...]float32{1.2, 3/3}
balance[4] = 5.78
func main() {
  var n [10]int
  var i, j int
  for i = 0; i < 10; i++ {
    n[i] = i + 100
  }
  for j = 0; j < 10; j++ {
    fmt.Printf("Element[%d] = %d\n", j, n[j])
  }
  var a = [5][2]int{{0,0}, {1,2}, {2,4}, {3,6}, {4,8}}
  var i, j int
  for i = 0; i < 5; i++ {
    for j = 0; j < 2; j++ {
      fmt.Printf("a[%d][%d] = %d\n", i, j, a[i][j])
    }
  }
}

package main

import "fmt"

const MAX INT = 3

func main() {
  a := []int{10,100.200}
  var i int
  var ptr [MAX]*int
  for i = 0; i < MAX; i++ {
    pre[i] = &a[i]
  }
  for i = 0; i < MAX; i++ {
    fmt.Printf("a'[%d] = %d \n", i, *ptr[i])
  }
}
package main

import "fmt"

type Books struct {
  title string
  author string
  subject string
  book_id int
}

func main() {
  var Book1 Books
  var Book2 Books
  Book1.title = "go"
  Book1.author = "runboob"
  Book1.subject = "subject"
  Book1.book_id  = 3584385734
  var numbers = make([]int, 3, 5)
  if(numbers == nil) {
    fmt.Printf("nil")
  }
}

func printSlice(x []int) {
  fmt.Printf("len = %d cap = %d slice = %v\n", len(x), cap(x), x)
}

package main

import "fmt"

func main() {
  numbers := []int{0,1,2,3,4,5,6,7,8}
  printSlice(numbers)
  fmt.Println("numbers == ", numbers)
  fmt.Println("numbers[1:4] == ", numbers[1:4])
  fmt.Println("numbers[:3] == ", numbers[:3])
  fmt.Println("numbers[4:] == ", numbers[4:])
  numbers1 := make([]int, 0, 5)
  printSlice(numbers1)
  numbers2 := numbers[:2]
  printSlice(number2)
  numbers3 := numbers[2:5]
  var numbers []int
  numbers = append(numbers, 0)
  numbers = append(numbers, 1)
  numbers = append(numbers, 2, 3, 4)
  numbers1 := make([]int, len(numbers), (cap(numbers)) * 2)
  copy(numbsers1, numbers)
}
package main

import "fmt"

func main() {
  nums := []int{2, 3, 4}
  sum := 0
  for _, num := range nums {
    sum += num
  }
  fmt.Println("sum: ", sum)
  for i, num := range nums {
    if num == 3 {
      fmt.Println("index: ", i)
    }
  }
  kvs := map[string]string{"a": "apple", "b": "banana"}

  for k, v := range kvs {
    fmt.Printf(i, c)
  }
  var countryCapitalMap map[string]string
  countryCapitalMap = make(map[string]string)

  countryCapitalMap["France"] = "Paris"
  countryCapitalMap["Italy"] = "Rome"
  countryCapitalMap["Japan"] = "Tokyo"
  countryCapitalMap["India"] = "New Dephi"

  for country := range countryCapitalMap {
    fmt.Printf("Capital of", country, "is", countryCapitalMap[country])
  }

  captial, ok := countryCapitalMap["United States"]
  if(ok) {
    fmt.Println("Captial of United States is", captial)
  } else {
    fmt.Println("Captial of United States is not present")
  }

  delete(countryCapitalMap, "France")
  fmt.Println("Entry for France is deleted")
}

func Factorial(n unit64)(result uint64){
  if (n > 0) {
    result = n * Factorial(n-1)
    return result
  }
  return 1
}

func fibonacci(n int) int {
  if n < 2 {
    return n
  }
  return fibonacci(n-2) + fibonacci(n-1)
}

func test() {
  var sum int = 17
  var count int = 5
  var mean float32
  mean = float32(sum)/float32(count)
}

package main

import (
  "fmt"
)

type Phone interface {
  call()
}

type NokiaPhone struct {

}
func (nokiaPhone NokiaPhone) call() {
  fmt.Println("I am Nokia, I can call you!")
}

type IPhone struct {

}

func (iPhone IPhone) call() {
  fmt.Printf("I am iPhone, I can call you!")
}
func main() {
  var phone Phone
  phone = new(NokiaPhone)
  phone.call()
  phone = new(IPhone)
  phone.call()
}

func Sqrt(f float64) (float64, error) {
  if f < 0 {
    return 0, error.New("math: square root of negative number")
  }
}

result, err:= Sqrt(-1)
if err != nil {
  fmt.Println(err)
}
package main

import (
  "fmt"
)

// 实现     `error` 接口
func (de *DivideError) Error() string {
    strFormat := `
    Cannot proceed, the divider is zero.
    dividee: %d
    divider: 0
`
    return fmt.Sprintf(strFormat, de.dividee)
}

func (de *DivideError) Error() string {
  strFormat := `
  Cannot proceed, the divider is zero.
  dividee: %d
  divider: 0
`
  return fmt.Sprintf(strFormat. de.dividee)
}

func Divide(vavrDividee int, varDivider int) (result int, errorMsg string) {
  if varDivider == 0 {
    dData := DivideError {
      dividee: varDividee,
      divider: varDivider,
    }
    errorMsg = dData.Eror()
    return
  } else {
    return varVividee / varDivider
  }
}

func main() {
  if result, errorMsg := Divide(100, 10); errorMsg == "" {
    fmt.Println("100/10 = ", result)
  }
  if _, errorMsg := Divide(100, 0); errorMsg != "" {
    fmt.Println("errorMsg is: ", errorMsg)
  }
}
