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

type cm struct {
	commands []string
	dest     string
	done     bool
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

	hm := make(map[string]uint16)

	str := strings.Split(dat, "\r\n")

	list := make([]cm, len(str))

	for i, s := range str {
		command := strings.Split(strings.Split(s, " -> ")[0], " ")
		dest := strings.Split(s, " -> ")[1]
		list[i] = cm{command, dest, false}
	}
	for _, c := range list { // check if all is done
		for _, c1 := range c.commands {
			val, err := strconv.ParseInt(c1, 10, 64)
			if err == nil {
				hm[c1] = uint16(val)
			}
		}
	}
	var loop bool = true
	for loop {

		for k, c := range list { // check if all is done
			if c.done {
				continue
			}
			var val uint16
			var val2 uint16
			var ex bool
			var ex2 bool
			if len(c.commands) == 1 {
				val, ex = hm[c.commands[0]]
				if !ex {
					continue
				}
				hm[c.dest] = val
				list[k].done = true

			} else if len(c.commands) == 2 {
				val, ex = hm[c.commands[1]]
				if !ex {
					continue
				}
				hm[c.dest] = ^val
				list[k].done = true

			} else if len(c.commands) == 3 {
				val, ex = hm[c.commands[0]]
				val2, ex2 = hm[c.commands[2]]
				if !ex || !ex2 {
					continue
				}
				if c.commands[1] == "AND" {
					hm[c.dest] = val & val2
				} else if c.commands[1] == "OR" {
					hm[c.dest] = val | val2
				} else if c.commands[1] == "LSHIFT" {
					hm[c.dest] = val << val2
				} else if c.commands[1] == "RSHIFT" {
					hm[c.dest] = val >> val2
				}
				list[k].done = true

			}
		}

		if total == 112 {
			loop = false
		} else {
			total++
		}

	}

	return int64(hm["a"])
}

func Part2(dat string) int64 {
	var total int64 = 0

	hm := make(map[string]uint16)

	str := strings.Split(dat, "\r\n")

	list := make([]cm, len(str))

	hm["b"] = 956

	for i, s := range str {
		command := strings.Split(strings.Split(s, " -> ")[0], " ")
		dest := strings.Split(s, " -> ")[1]
		list[i] = cm{command, dest, false}
	}
	for _, c := range list { // check if all is done
		for _, c1 := range c.commands {
			val, err := strconv.ParseInt(c1, 10, 64)
			if err == nil {
				hm[c1] = uint16(val)
			}
		}
	}
	var loop bool = true
	for loop {

		for k, c := range list { // check if all is done
			if c.done {
				continue
			}
			if c.dest == "b" {
				continue
			}
			var val uint16
			var val2 uint16
			var ex bool
			var ex2 bool
			if len(c.commands) == 1 {
				val, ex = hm[c.commands[0]]
				if !ex {
					continue
				}
				hm[c.dest] = val
				list[k].done = true

			} else if len(c.commands) == 2 {
				val, ex = hm[c.commands[1]]
				if !ex {
					continue
				}
				hm[c.dest] = ^val
				list[k].done = true

			} else if len(c.commands) == 3 {
				val, ex = hm[c.commands[0]]
				val2, ex2 = hm[c.commands[2]]
				if !ex || !ex2 {
					continue
				}
				if c.commands[1] == "AND" {
					hm[c.dest] = val & val2
				} else if c.commands[1] == "OR" {
					hm[c.dest] = val | val2
				} else if c.commands[1] == "LSHIFT" {
					hm[c.dest] = val << val2
				} else if c.commands[1] == "RSHIFT" {
					hm[c.dest] = val >> val2
				}
				list[k].done = true

			}
		}

		if total == 500 {
			loop = false
		} else {
			total++
		}

	}

	return int64(hm["a"])
}

/*

	commands := strings.Split(s, " ")
	if len(commands) == 3 { //NOTHING
		value, exists := hm[commands[0]]
		if !exists {
			key, _ := strconv.ParseInt(commands[0], 10, 16)
			value = uint16(key)
		}
		hm[commands[2]] = value
	} else if len(commands) == 4 {
		if commands[0] == "NOT" { //NOT
			value, exists := hm[commands[1]]
			if !exists {
				key, _ := strconv.ParseInt(commands[1], 10, 16)
				value = uint16(key)
			}
			hm[commands[3]] = ^value
		}
	} else if len(commands) == 5 {
		value1, exists1 := hm[commands[0]]
		if !exists1 {
			key, _ := strconv.ParseInt(commands[0], 10, 16)
			value1 = uint16(key)
		}
		value2, exists2 := hm[commands[2]]
		if !exists2 {
			key, _ := strconv.ParseInt(commands[2], 10, 16)
			value2 = uint16(key)
		}
		if commands[1] == "AND" { //AND
			hm[commands[4]] = value1 & value2
		} else if commands[1] == "OR" { //OR
			hm[commands[4]] = value1 | value2
		} else if commands[1] == "LSHIFT" { //LEFT SHIFT
			hm[commands[4]] = value1 << value2
		} else if commands[1] == "RSHIFT" { //RIGHT SHIFT
			hm[commands[4]] = value1 >> value2
		}
	}



*/
