package main

import (
	"crypto/md5"
	"encoding/hex"
	"fmt"
	"strconv"
)

func main() {
	var dat = "ckczppom"

	//fmt.Printf(string(dat))

	fmt.Printf("Part 1: %d\n", Part1(string(dat)))
	fmt.Printf("Part 2: %d\n", Part2(string(dat)))

}

func Part1(dat string) int64 {
	var n = 0
	for {
		data := []byte(dat + strconv.Itoa(n))
		hash := md5.Sum(data)

		// Convert the [16]byte array to a slice and then to a hexadecimal string
		s := hex.EncodeToString(hash[:])[:5]
		if s == "00000" {
			break
		}
		n++
	}
	return int64(n)
}

func Part2(dat string) int64 {
	var n = 0
	for {
		data := []byte(dat + strconv.Itoa(n))
		hash := md5.Sum(data)

		// Convert the [16]byte array to a slice and then to a hexadecimal string
		s := hex.EncodeToString(hash[:])[:6]
		if s == "000000" {
			break
		}
		n++
	}
	return int64(n)
}
