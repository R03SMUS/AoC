package main

import (
	"fmt"
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

func Part1(dat string) int {
	var total = dat

	for i := 0; i < 40; i++ {
		do(&total)
	}

	return len(total)
}

func do(n *string) {
	var tmp = *n

	var current int32 = int32(tmp[0])
	var l int32 = 0
	var sb strings.Builder // this makes it 128937128973618273658197253897612538976125387961258 times faster btw :3

	for _, s := range tmp {
		//fmt.Println(string(s))
		if current == s {
			l++
		} else {
			sb.WriteString(strconv.Itoa(int(l)))
			sb.WriteString(string(current))
			l = 1
			current = s
		}

	}
	sb.WriteString(strconv.Itoa(int(l)))
	sb.WriteString(string(current))

	*n = sb.String()

}

func Part2(dat string) int {
	var total = dat

	for i := 0; i < 50; i++ {
		do(&total)
	}

	return len(total)
}
