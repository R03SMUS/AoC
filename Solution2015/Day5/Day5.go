package main

import (
	"fmt"
	"os"
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
	vowel := "aeiou"
	for _, s := range strings.Split(dat, "\r\n") {
		threevowels := 0
		twoletters := false
		forbidden := false
		for i, str := range s {
			if strings.Contains(vowel, string(str)) {
				threevowels++
			}
			if !twoletters && i != len(s)-1 && str == rune(s[i+1]) {
				twoletters = true
			}
			if i != len(s)-1 && str == 'a' {
				if rune(s[i+1]) == 'b' {
					forbidden = true
				}
			} else if i != len(s)-1 && str == 'c' {
				if rune(s[i+1]) == 'd' {
					forbidden = true
				}
			} else if i != len(s)-1 && str == 'p' {
				if rune(s[i+1]) == 'q' {
					forbidden = true
				}
			} else if i != len(s)-1 && str == 'x' {
				if rune(s[i+1]) == 'y' {
					forbidden = true
				}
			}
		}
		if threevowels >= 3 && twoletters && !forbidden {
			total++
		}
	}
	return total
}

func Part2(dat string) int64 {
	var total int64 = 0

	for _, s := range strings.Split(dat, "\r\n") {
		pair := false
		repeats := false

		for i, str := range s {
			if !repeats && i < len(s)-2 && str == rune(s[i+2]) {
				repeats = true
			}

			if !pair && i < len(s)-2 && strings.Contains(s[i+2:], s[i:i+2]) {
				pair = true
			}

		}

		if pair && repeats {
			total++
		}
	}
	return total
}
