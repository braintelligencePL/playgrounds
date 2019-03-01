Dzisiaj pobawimy się pożyczkowym wzorcem, a mianowicie Loan Pattern. Na jego podstawie zrobimy sobie funkcyjnego TryCatcha. Jest to wzorzec wywodzący się bardziej ze środowiska funkcyjnego tuteż Scalowego. Java ostatnimi czasy również stara się zainstnieć w tym świecie i tak właśnie powstało kilka bibliotek umożliwiających tworzenie bardziej funkcyjnego kodu. Przedstawimy sobie takie biblioteki jak Vavr, oraz JOOλ.

#### Szable w dłoń i robimy FP!
### Ale zacznijmy od początku... 
Funkcjnie, czyli mamy... funkcje, metody. Mają one jakiś input oraz output. Kluczowym konceptem jest tutaj modułowość. Możemy rozbić nasz algorytm, czy cokolwiek tam robimy na mniejsze pod-funkcje. Jak wiadomo nasze umysły mają tylko ograniczoną ilość RAMu do rozwiązywania codziennych problemów, dlatego wymyślamy koncepty, paradygmaty, standardy aby uprościć to wszystko. Małe moduły mogą być kodzone szybko i być łatwo testowane. Do tego jest możliwe ich re-używanie. Czyli mamy w sumie kilka najważniejszych zasad dobrego kodu spakowane do jednego worka z tego też powodu programowanie zorientowane na funkcje staje się poopularne. Niemniej! Warto też dodać, że nie znaczy to, że programowanie obiektowe jest już passé. Wręcz przeciwnie oba paradygmaty doskonale ze sobą współpracują. 

Dobra może nie do końca współpracują, ale bardziej zastępują niektóre techniki zawierające się w innych paradygmatach. Mamy chociażby przekazywanie funkcji jako paramter do innych funkcji, czyli higher-order functions - istna incepcja. Drugą rzeczą sklejającą się na programowanie funkcyjne jest coś takiego jak first-class citizen. Jest to traktowanie funkcji jako wartości. Znaczy to tyle, że jeśli mamy `listAvailableCustomer(Customer::isAvailable)` to do naszej methody <b>listAvailableCustomer</b> przekazujemy inną funkcję. 

Jest jeszcze parę innych pojęć jakie  anonymous functions, closures, lazy-evaluation i wiele innych rzeczy wychodzących poza ten wpis. Rzeczy te pojawiją się często w językach funkcjonalnych i są praktycznie spowiwem tworzącym język funkcjonalym. 

## Nie język czyni programowanie funkcyjnym
Mimo, że haskell jest praktycznym przykładem czysto funkcjonalnego języka to jednak nie język czyni programowanie funkcyjnym. Takowy język daje nam tyle, że jest bardziej przyjazny programowaniu funkcyjnemu, ale w sposób funkcyjny można pisać w większości języków jakie mają higher-order functions. 

## 

# Osobny Wpis (or not) #

## Na początek zacznijmy od starego i wciąż dobrego (co warto podkreślić) TryCatcha:
// todo: 

## To teraz czas na mięso 🍗  (Loan Pattern)
// todo: 

## JOOλ.append(Vavr).build()
// todo: 
