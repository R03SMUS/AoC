package main

import (
	"fmt"
	"strings"
)

func check(e error) {
	if e != nil {
		panic(e)
	}
}

func main() {
	dat := "hepxcrrq"
	dat2 := "hepxxyzz"
	//fmt.Printf(string(dat))

	fmt.Printf("Part 1: %s\n", Part1(string(dat)))
	fmt.Printf("Part 2: %s\n", Part1(string(dat2)))

}

func Part1(dat string) string {

	list := make([]int, 8)

	for i, s := range dat {
		list[i] = int(s)
	}

	var password bool = false

	for !password {
		//fmt.Println(list)
		list[7]++
		for i := 7; i > 0; i-- {
			if list[i] == 123 {
				list[i] = 97
				list[i-1]++
			}
		}
		//fmt.Println(list)
		var abc bool = false
		var aabb bool = false
		var iol bool = true
		var a bool = false
		var b bool = false
		var aa int

		for i := range list {
			//A->B->C
			if i < 6 {
				if list[i]+1 == list[i+1] && list[i]+2 == list[i+2] {
					abc = true
				}
			}
			//IOL
			if list[i] == 'i' || list[i] == 'o' || list[i] == 'l' {
				iol = false
			}
			//AA->BB

			if i < 7 {
				if !a {
					if list[i] == list[i+1] {
						a = true
						aa = list[i]
						//fmt.Println("a", list[i], i)
					}

				} else {
					if list[i] == list[i+1] && list[i] != aa {
						b = true
						//fmt.Println("b", list[i], i)
					}
				}
				if a && b {
					aabb = true
				}
			}

		}

		//fmt.Println(abc, aabb, iol)
		//password = true
		if abc && aabb && iol {
			password = true
		}
	}

	//fmt.Println(list)
	var sb strings.Builder

	for _, v := range list {
		sb.WriteString(string(rune(v)))
	}

	//fmt.Println()

	return sb.String()
}
