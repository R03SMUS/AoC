open System
open System.IO


let split (text: string) =
    let charSeq = text//.Substring(0, 10)
                |> Seq.toArray
    charSeq
    |> Seq.zip (Seq.append (Seq.tail charSeq) [| charSeq.[0] |])
    
let sum (array: (char * char) seq) =
    let mutable total = 0
    for l in array do
        if fst l = snd l then
            total <- total + int (Char.GetNumericValue (fst l)) 
    total

let part2 (text: string) =
    let mutable total = 0
    let charSeq = text
                |> Seq.toArray
    let len = charSeq.Length
    charSeq
    |> Array.mapi (fun index value ->
        if value = charSeq.[(len/2+index)%len] then
            total <- total + int (Char.GetNumericValue value)
        )
    |> ignore
    total
let file = "Solution2017\\Day1\\input"
let n = File.ReadAllLines(file)
let s = sum (split n.[0])
let ss = part2 n.[0]
printfn $"Part 1: {s}" 
printfn $"Part 2: {ss}"

    

