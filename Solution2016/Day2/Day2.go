package main

import (
	"fmt"
	"os"
	"strings"
)

func main() {

	dat, _ := os.ReadFile("input")

	part1(string(dat))
	fmt.Println()
	part2(string(dat))

}
func part1(s string) {
	keypad := [][]int{
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9},
	}
	x, y := 1, 1
	for _, str := range strings.Split(string(s), "\r\n") {
		for _, c := range str {
			if c == 'U' { //UP
				if x != 0 {
					x--
				}
			} else if c == 'D' {
				if x != 2 {
					x++
				}
			} else if c == 'L' {
				if y != 0 {
					y--
				}
			} else if c == 'R' {
				if y != 2 {
					y++
				}
			}
		}
		//fmt.Println(x, y)
		fmt.Print(keypad[x][y])
	}
}
func part2(s string) {
	keypad := [][]int{
		{0, 0, 1, 0, 0},
		{0, 2, 3, 4, 0},
		{5, 6, 7, 8, 9},
		{0, 'A', 'B', 'C', 0},
		{0, 0, 'D', 0, 0},
	}

	x, y := 2, 0
	for _, str := range strings.Split(string(s), "\r\n") {
		for _, c := range str {
			if c == 'U' { //UP

				if ((y == 1 || y == 3) && x != 1) || (y == 2 && x != 0) {
					x--
				}

			} else if c == 'D' {

				if ((y == 1 || y == 3) && x != 3) || (y == 2 && x != 4) {
					x++
				}

			} else if c == 'L' {

				if ((x == 1 || x == 3) && y != 1) || (x == 2 && y != 0) {
					y--
				}

			} else if c == 'R' {

				if ((x == 1 || x == 3) && y != 3) || (x == 2 && y != 4) {
					y++
				}

			}

		}
		//fmt.Println(x, y)
		if keypad[x][y] > 10 {
			fmt.Print(string(rune(keypad[x][y])))
		} else {
			fmt.Print(keypad[x][y])
		}

	}

}
