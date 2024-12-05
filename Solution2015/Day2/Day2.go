package main

import (
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

func check(e error) {
	if e != nil {
		panic(e)
	}
}

func main() {
	dat, err := os.ReadFile("input")
	check(err)

	//fmt.Printf(string(dat))

	fmt.Printf("Part 1: %d\n", Part1(string(dat)))
	fmt.Printf("Part 2: %d\n", Part2(string(dat)))

}

func Part1(dat string) int64 {

	var total int64 = 0

	s := strings.Split(dat, "\r\n")

	for _, str := range s {
		numbers := strings.Split(str, "x")

		var a [3]int64
		var b int = 0
		for _, num := range numbers {
			a[b], _ = strconv.ParseInt(num, 10, 64)
			b++
		}
		var side1 int64 = a[0] * a[1]
		var side2 int64 = a[1] * a[2]
		var side3 int64 = a[0] * a[2]
		total += 2*(side1+side2+side3) + int64(math.Min(math.Min(float64(side1), float64(side2)), float64(side3)))

	}

	return total
}

func Part2(dat string) int64 {
	var total int64 = 0

	s := strings.Split(dat, "\r\n")

	for _, str := range s {
		numbers := strings.Split(str, "x")

		var a [3]int64
		var b int = 0
		for _, num := range numbers {
			a[b], _ = strconv.ParseInt(num, 10, 64)
			b++
		}
		var side1 int64 = a[0]
		var side2 int64 = a[1]
		var side3 int64 = a[2]

		total += 2 * (side1 + side2 + side3 - int64(math.Max(math.Max(float64(side1), float64(side2)), float64(side3))))
		total += side1 * side2 * side3
	}

	return total
}
