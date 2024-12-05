package main

import (
	"fmt"
	"os"
)

func check(e error) {
	if e != nil {
		panic(e)
	}
}

func main() {
	dat, err := os.ReadFile("input")
	check(err)
	fmt.Printf("Part 1: %d\n", Part1(string(dat)))
	fmt.Printf("Part 2: %d\n", Part2(string(dat)))

}

func Part1(dat string) int {
	var level int = 0

	for _, char := range dat {
		if char == '(' {
			level++
		} else {
			level--
		}
	}
	return level
}

func Part2(dat string) int {
	var level int = 0
	var pos int = -1

	for p, char := range dat {
		if char == '(' {
			level++
		} else {
			level--
		}

		if level < 0 {
			pos = p + 1
			break
		}
	}
	return pos
}
