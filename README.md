# Webblog

## Epic

### Name
Entwicklung eines öffentlichen Webblogs

### Beschreibung
Ein Webblog soll entwickelt und betrieben werden. 

Registrierte Nutzerinnen und Nutzer dürfen Posts erstellen und diese ändern und löschen. Administratoren dürfen alle Posts löschen aber nicht ändern. Alle Posts können von anderen Nutzenden kommentiert und mit 1 bis 5 Sternen bewertet werden.

## Software Design
Die Anwendung wird mit Java zunächst ohne zusätzliche Frameworks entwickelt. 

Dabei verfolgt das Design die 3-Tier-Architektur mit einem User-Interface (UI), das über die Hilfsklasse ```Scnanner``` auf Kommandozeilenebene umgesetzt wird. einer Service-Schicht mit der Geschäftslogik und einer Persistenz-Schicht mit der Datenhaltung. 

Für die Geschäftslogik wird die objektorientiere Programmierung (OOP) als Herangehensweise gewählt. Dabei werden die Begriffe aus den Anforderungen (Epic und User Stories) in ein Klassenmodell überführt. 

Die Persistenz kann wahlweise im Speicher erfolgen oder über eine (CSV-)Datei, welche die Posts etc. enthält, gebaut werden. 

Entscheidend ist, dass alle drei Schichten zuvor definierte Schnittstellen erhalten, welche genau beschreiben, was erlaubt ist, welche Parameter benötigt werden und was sie der aufrufenden Schicht zurückliefert.

## Testing
Alle Funktionen der Anwendung sollen per Unit-Tests getestet werden. Dabei sind die Akzeptanzkriterien, die in den User Stories festgelegt werden, abzutesten. Eine funktion ist fertig, wenn alle Kriterien erfüllt sind. 

## Aufgaben
* Anforderungen in Einzelaufgaben herunterbrechen und im Team aufteilen.
* Akzeptanzkriterien für die Einzelaufgaben festlegen.
* Softwaredesign ausarbeiten und die Klassen und Methoden erstellen.
* Testfälle aus den Aktzeptanzkriterien ableiten. 
* Java-Projekt in VSCode mit (mind.) einem Package (z.B. de.awacademy.training.web.blog) anlegen und über GitHub teilen.
* Klassen, Methoden und Unittests anhand des erarbeiteten Softwaredesigns und der Testfälle erzeugen.
