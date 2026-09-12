#include <iostream>
#include <string>
using namespace std;

int main() {
    double n1, n2, n3, avance;
    int errores;
    string doc, expo;

    cout << "Nota de analisis: ";
    cin >> n1;
    cout << "Nota de diseno: ";
    cin >> n2;
    cout << "Nota de codificacion: ";
    cin >> n3;
    cout << "Porcentaje de avance real: ";
    cin >> avance;
    cout << "Numero de errores: ";
    cin >> errores;
    cout << "¿Documentacion completa? (S/N): ";
    cin >> doc;
    cout << "¿Realizo exposicion final? (S/N): ";
    cin >> expo;

    double promedio = (n1 + n2 + n3) / 3;
    double ajustes = -(errores * 0.5);

    if (doc == "S" || doc == "s") ajustes += 0.5;
    if (expo == "S" || expo == "s") ajustes += 0.5;

    double notaFinal = promedio + ajustes;
    if (notaFinal > 10) notaFinal = 10;
    if (notaFinal < 0) notaFinal = 0;

    string estado;
    if (notaFinal >= 9 && avance < 60) {
        estado = "Aprobado";
    } else if (notaFinal >= 9) {
        estado = "Excelente";
    } else if (notaFinal >= 7) {
        estado = "Aprobado";
    } else if (notaFinal >= 5) {
        estado = "Recuperacion";
    } else {
        estado = "Reprobado";
    }

    string observacion = "Ninguna";
    if (notaFinal >= 8 && (doc == "N" || doc == "n")) {
        observacion = "Buen producto, pero mala formalidad";
    }

    cout << "Promedio tecnico: " << promedio << endl;
    cout << "Ajustes aplicados: " << ajustes << endl;
    cout << "Nota final: " << notaFinal << endl;
    cout << "Estado: " << estado << endl;
    cout << "Observacion: " << observacion << endl;

    return 0;
}