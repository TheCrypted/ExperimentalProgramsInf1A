{-# OPTIONS_GHC -Wno-incomplete-patterns #-}
{-# LANGUAGE TupleSections #-}
import Data.Char
import GHC (IE(IEDocNamed))
import GHC.Base (VecElem(Int16ElemRep))
-- import Tutorial2 (multDigits)

root :: Float -> Float -> Float -> Float
root a b c
    | b^2 - 4*a*c >= 0 =(-b + sqrt(b^2 -4*a*c))/(2*a) -- ++ " and " ++ (-b - sqrt(b^2 -4*a*c))/(2*a)
    | b^2 - 4*a*c < 0 = 0

between :: Int -> Int -> Int -> Int
between a b c
    | (b<= a && c>= a) || (c<= a && b>= a) = a
    | (a<= c && b>= c) || (b<= c && a>= c) = c
    | otherwise  = b

xor :: Bool -> Bool -> Bool
xor a b
    | a && b = False
    | a || b = True
    | otherwise  = False

str :: String
str = "String"

count :: [Int]
count = [1..100]

bell :: [(Int, Bool)]
bell = [(x, even x) | x <- count, even x]

metreToFeet :: Float -> (Float, Float)
metreToFeet metres = (feet, inches)
    where feet = metres * 3.2808
          inches = (metres * 12 * 3.2808) - (12 * feet)

tripGen :: [(Int, Int, Int)]
tripGen = [ (a, b, c) | a <- count, b <- count, c <- count, a^2 + b^2 == c^2 && c <=50]

type Line = (Float, Float)
intersectL :: Line -> Line -> (Float, Float)
intersectL (a,b) (c,d) = ((b-d)/(c-a), (a *(b-d)/(c-a)) + b)

halveEvens :: [Int] -> [Int]
-- halveEvens xs = [if even x then x `div` 2 else x | x <- xs]
halveEvens xs = [ x `div` 2 | x <- xs, even x]

inRange :: Int -> Int -> [Int] -> [Int]
inRange a b xs = [x | x <- xs, x>= a && b>= x]

-------------------------------------------------------------------------------------------------------------------------------
isVowel :: Char -> Bool
isVowel x = x `elem` "AEIOUaeiou"

{- score :: Char -> Int
score x = i
    where
    scor :: Num a => a -> a -> a -> Int
    scor x i l
        | l /= 3 && isAlpha x = i+1 l+1
        | l/= 3 && isUpper x = i+1 && l+1
        | l/= 3 && isVowel x = i+1 && l+1
        |otherwise = i 

totalScore :: String -> Int
totalScore xs = product [score x | x <- xs, isAlpha x]

prop_totalScore_pos :: String -> Bool
prop_totalScore_pos xs = totalScore [x | x <- xs, isAscii x]  >= 1 
-}
-- 5. crosswordFind

crosswordFind :: Char -> Int -> Int -> [String] -> [String]
crosswordFind letter pos len words = [x | x <- words, (x !! pos == letter) && (length x == len)]


-- 6. search
search :: String -> Char -> [Int]
search str goal = [x | let m = length str, x <- [0..m], str !! x == goal  ]

-- Depending on the property you want to test, you might want to change the type signature
prop_search :: String -> Char -> Bool
prop_search str goal = undefined

-- 3
capitalise :: String -> String
capitalise word = toUpper(head (word)) : tail[toLower x | x <- word]

titl :: String -> String
titl wor
    | length wor >= 4 = capitalise wor
    | otherwise = [ toLower x | x <- wor]

title :: [String] -> [String]
title words = capitalise(head words) : tail[titl x | x <- words]

{- capitalise :: String -> String
capitalise word = toUpper(head (word)) : tail[toLower x | x <- word]

title :: [String] -> [String]
title words = [x | x <- words, length x >= 4]-}

-------------------------


-- FP Lecture 4
factorialRec :: Int -> Int
factorialRec n = fact 1 n
    where
        fact :: Int -> Int -> Int
        fact m n
            |m > n = 1
            | m <= n = m * fact(m+1) n

factAlpha :: Int -> Int -> Int
factAlpha m n
    | m <= n = m * factAlpha(m+1) n
    | m > n = 1

dotProduct :: Num a => [a] -> [a] -> a
dotProduct [] [] = 0
dotProduct (a:as) (b:bs) = a * b + dotProduct as bs

-- Book Reading / Exercises
halveEvensRec :: [Int] -> [Int]
halveEvensRec [] = []
halveEvensRec (x:xs)
    | even x = (x `div` 2): halveEvensRec xs
    | otherwise = halveEvensRec xs

qw :: [Int] -> Bool
qw xs = halveEvens xs == halveEvensRec xs

inRangeRec :: Int -> Int -> [Int] -> [Int]
inRangeRec lo hi [] = []
inRangeRec lo hi (x:xs)
    | lo <= x && x <= hi = x : inRangeRec x hi xs
    | otherwise = inRangeRec lo hi xs

multDigitsRec :: String -> Int
multDigitsRec [] = 1
multDigitsRec (s:str)
    | isDigit s = digitToInt s * multDigitsRec str
    | otherwise = multDigitsRec str

factorial :: Int -> Int
factorial 0 = 1
factorial n = n * factorial(n-1)

isPrime :: Int -> Bool
isPrime x = null[y | y <- [2..(x-1)], x `mod` y == 0]


listPrime :: [Int]
listPrime = [x | x <- [2..], isPrime x ]

sumAlpha :: [Int] -> Int
sumAlpha  = foldr (+) 0

pow2 :: Integer -> Integer
pow2 = (2 ^)


-- Chapter 12--------------------------------------------------------------------------------------------------------------------------------------------

allxs :: (a -> Bool) -> [a] -> Bool
allxs x xs = all x xs

div3 :: Integral a => a -> Bool
div3 x = x `mod` 3 == 0

allPosDiv3 :: Integral a => [a] -> Bool
allPosDiv3 = allxs div3

--3
rmChar :: Eq a => a -> [a] -> [a]
rmChar x = filter (x /= )



rmChars :: String -> String -> String
rmChars (x:xs) [] = []
rmChars [] ys = ys
rmChars (x:xs) ys =  rmChars xs $rmChar x ys

--4.
patternAlpha :: ([a] -> t) -> (a -> Bool) -> [a] -> t
patternAlpha a b xs = a (filter (b) xs)

halveEvensHO :: [Int] -> [Int]
halveEvensHO [] = []
halveEvensHO xs = patternAlpha (map(`div` 2 )) even xs

--5.
countPositivesHO :: (Ord a, Num a) => [a] -> Int
countPositivesHO = patternAlpha length (>=0)

--6.   
multDigitsHO :: [Char] -> Int
multDigitsHO xs = product $ map digitToInt $ filter isDigit xs


-- 13. -----------------------------------------------------------------------------------------------------------------------------

--1. 
addOne :: Integer -> Integer
addOne  = (*2)

addOne' :: [Integer] -> [Integer]
addOne' (x:xs) = addOne x : addOne' xs

{-
iter ::  Int -> (Int -> Int) -> (Int -> Int)
iter n  = foldr1 (.) (replicate n (addOne')
-}

iter :: Int -> (a -> a) -> (a -> a)
iter n f = foldr1 (.) $ replicate n f

--2. 

flipA :: (t1 -> t2 -> t3) -> t2 -> t1 -> t3
flipA f x y = f y x

subtractA :: Num a => a -> a -> a -> a
subtractA a b c = a -b -c

--3.

takeWhileA :: (a -> Bool) -> [a] -> [a]
takeWhileA check [] = []
takeWhileA check (l:list)
    | check l = l : takeWhileA check list
    | otherwise = takeWhileA check list

dropWhileA :: (a -> Bool) -> [a] -> [a]
dropWhileA check [] = []
dropWhileA check (l:list)
    | check l = takeWhileA check list
    | otherwise = l: takeWhileA check list

--and (map (check) list) 

--4. 
zipWithA :: (a -> b -> c) -> [a] -> [b] -> [c]
zipWithA f [] ys = []
zipWithA f xs [] = []
zipWithA f (x:xs) (y:ys)
    | abs (length (x:xs) - length (y:ys)) == 0 = x `f` y : zipWithA f xs ys
    | otherwise = error " lists are not the same length"

--zipWithB f xs ys = map f ()  

h :: (Num p, Ord p) => [p] -> p
h [] = 1
h (x:xs) | x <0 = x*x*x * h xs
    | otherwise = h xs

