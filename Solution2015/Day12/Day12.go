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

func Part1(dat string) int64 {
	var total int64 = 0
	var nl = true

	var sb strings.Builder

	list := make([]string, 0)
	for _, s := range dat {
		if s == '0' || s == '1' || s == '2' || s == '3' || s == '4' || s == '5' || s == '6' || s == '7' || s == '8' || s == '9' || s == '-' || s == '+' {
			sb.WriteString(string(s))
			nl = true
		} else {
			if nl {
				list = append(list, sb.String())
				sb.Reset()
			}
			nl = false
		}

	}
	for _, v := range list {
		n, _ := strconv.ParseInt(v, 10, 64)
		//fmt.Println(n, total)
		total += n
	}

	return total
}

type xy struct {
	start int
	end   int
}

func Part2(dat string) int64 {
	list := make([]xy, 0)
	removing := make(map[int]bool, len(dat))

	for i := range dat {
		removing[i] = false
		var left int = 1
		var right int = 1

		if dat[i] == 'r' && dat[i+1] == 'e' && dat[i+2] == 'd' {
			//fmt.Println(i)
			var leftn = 0
			var rightn = 0

			for j := 1; left != 0; j++ {
				leftn++

				//fmt.Println(i, j, left)

				if dat[i-j] == '[' || dat[i-j] == '{' {
					left--
				}
				if dat[i-j] == ']' || dat[i-j] == '}' {
					left++
				}
			}

			for j := 1; right != 0; j++ {
				rightn++

				//fmt.Println(i, j, left)

				if dat[i+j] == '[' || dat[i+j] == '{' {
					right++
				}
				if dat[i+j] == ']' || dat[i+j] == '}' {
					right--
				}
			}
			if dat[i-leftn] != '[' && dat[i+rightn] != ']' {
				list = append(list, xy{i - leftn, i + rightn})
				//fmt.Println(i, " -> ", leftn, string(dat[i-leftn]), " | ", rightn, string(dat[i+rightn]))
			}

		}
	}

	for i, j := 0, len(list)-1; i < j; i, j = i+1, j-1 {
		list[i], list[j] = list[j], list[i]
	}

	for _, s := range list {
		for a := s.start; a < s.end; a++ {
			removing[a] = true
		}
	}

	var sb strings.Builder

	for i, s := range dat {
		if !removing[i] {
			sb.WriteString(string(s))
		}

	}
	return Part1(sb.String())
}
