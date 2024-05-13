[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/Brmc3bbE)
# Hausaufgabe Nr. 3

In dieser Hausaufgabe geht es darum das Burger-Chatbot Programm 'intelligenter' zu machen.
So soll es beispielsweise Mehrfachnennungen von Zutaten verstehen und Schreibfehler tolerieren.

## Abgabe

Nehmen Sie das Assignment auf Github Classroom an und wählen Sie Ihren Namen aus der Liste aus.
Dadurch wird ein (dieses) Repository für Sie erstellt. 
Klonen Sie das Repo und pushen Sie Ihre Lösungen in mehreren sinnvoll zusammengefassten Commits (z.B. einer pro Teilaufgabe, es können aber auch gerne mehr sein).
Sie müssen Ihre Lösung bis zum 26. Mai um 23:59 Uhr gepusht haben, alle Tests müssen grün sein (und zwar nicht nur lokal, sondern auch auf GitHub im Tab "Actions"), und Sie müssen spätestens in der darauf folgenden von Ihnen belegten Übungsgruppe Ihre Lösung kurz demonstrieren.

## Aufgabenstellung

0. Betrachten Sie die Klassen `Menu` und `MenuUtils` im Paket `data` und die verschiedenen Klassen im Paket `service/parsing`, sowie die dazugehörigen Tests wie etwa `MenuUtilsTest` und `CountingInputParserTest`, die das Soll-Verhalten dieser Klassen spezifizieren.
1. Implementieren Sie in der Klasse `MenuUtils` die Methode `focusOnNameAndInvert`, sodass der dazu passende Test grün wird. Erstellen Sie außerdem einen weiteren Testfall, der einen Methodenaufruf mit leeren Eingaben prüft ("leer" kann hier unterschiedliches bedeuten, suchen Sie sich etwas aus).
2. Implementieren Sie in der Klasse `MenuUtils` die Methode `ingredientsFromIdAndCount`, sodass der dazu passende Test grün wird. Erstellen Sie außerdem einen weiteren Testfall, der einen Methodenaufruf mit leeren Eingaben prüft.
3. Implementieren Sie in der Klasse `CountingInputParser` die Methode `idsAndCountFromInput`, sodass der passende Test `CountingInputParserTest` sowie der `UIParserBuilderIntegrationTest` grün werden. 
4. Implementieren Sie in der Klasse `TypoTolerantInputParser` die Methode `idsAndCountFromInput`, sodass der passende Test grün wird. Je nach Implementierungsansatz, kann es sein, dass Ihre Counting-Parser-Logik hier unverändert funktioniert.
5. [Optional] Implementieren Sie in der Klasse `SmartInputParser` die Methode `idsAndCountFromInput`, sodass der passende Test grün wird. Verwenden Sie in der Klasse `BurgerBotApp` anstelle des `DummyInputParsers` Ihren `SmartInputParser`.

## Hinweise 
- Für den `CountingInputParser` schauen Sie sich die Methode `split` der Klasse `String` an und recherchieren Sie nach Beispielen, die reguläre Ausdrücke (regular expressions) verwenden.
- Implementieren Sie gerne weitere Testfälle zu den verschiedenen Parsern. Häufig hilft es bei der Lösungsfindung weitere Beispiele von Soll-Verhalten in Form von Tests zu formulieren.
