void main() {
// 1. String → int
String texto1 = '10';
int numero1 = int.parse(texto1);
print('String → int: $numero1');

// 2. String → double
String texto2 = '10.5';
double numero2 = double.parse(texto2);
print('String → double: $numero2');

// 3. int → String
int numero3 = 10;
String texto3 = numero3.toString();
print('int → String: $texto3');

// 4. double → String
double numero4 = 10.5;
String texto4 = numero4.toString();
print('double → String: $texto4');

// 5. int → double
int numero5 = 10;
double resultado5 = numero5.toDouble();
print('int → double: $resultado5');

// 6. double → int (trunca, não arredonda)
double numero6 = 10.5;
int resultado6 = numero6.toInt();
print('double → int (toInt): $resultado6');

// 6.1 double → int (arredondando)
int arredondado = numero6.round();
print('double → int (round): $arredondado');
}
