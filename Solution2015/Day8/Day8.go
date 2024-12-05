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
	for _, s := range strings.Split(dat, "\r\n") {
		var tl int64 = int64(len(s))
		var l int64 = int64(len(s) - 2)
		for i := 1; i < len(s)-1; i++ {
			if s[i] == '\\' && (s[i+1] == '\\' || s[i+1] == '"') {
				i++
				l--
			} else if s[i] == '\\' && s[i+1] == 'x' {
				i += 3
				l -= 3
			}
		}
		total += (tl - l)
	}
	return total
}

func Part2(dat string) int64 {
	var total int64 = 0
	for _, s := range strings.Split(dat, "\r\n") {
		var tl int64 = int64(len(s))
		var l int64 = int64(len(s) + 2)
		for i := 0; i < len(s); i++ {
			if s[i] == '\\' || s[i] == '"' {
				l++
			}
		}
		//fmt.Println(l, tl)
		total += (l - tl)
	}
	return total
}
