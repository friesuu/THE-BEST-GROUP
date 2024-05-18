#include <iostream>
#include <iomanip>
#include <math.h>

using namespace std;

int main()
{
    char ss,xx;
    int n, m, y, z;
    float x, d;
    int Card, Ewallet;
    int Yes, No;

    cout << "******* Coffee Bot *******" << endl;
    cout << "\nChoose your favourite drink" << endl;
    cout << "" << endl;
    cout << "A = Americano RM5.50\nC = Chocolate RM6.50\nL = Latte RM6.50\nG = Green Tea Latte RM6.50" << endl;
    cout << "" << endl;

    cout << "ORDER" << endl;
    cin >> ss;
    cout << "Enter the number of items." << endl;
    cin >> n;

    cout << "\n__" << endl;
    switch (ss)
    {
    case 'A':
        x = n * 5.50;
        cout << "Americano = RM" << fixed << setprecision(2) << x;
        break;
    case 'C':
        x = n * 6.50;
        cout << "Chocolate = RM" << fixed << setprecision(2) << x;
        break;
    case 'L':
        x = n * 6.50;
        cout << "Latte = RM" << fixed << setprecision(2) << x;
        break;
    case 'G':
        x = n * 6.50;
        cout << "Green Tea Latte = RM" << fixed << setprecision(2) << x;
        break;
    }

    cout << "\nWould you like to add a different drink? Yes or No." << endl;
    cin >> z;

    if (z == Yes)
    {
        cout << "ORDER" << endl;
        cin >> xx;
        cout << "Enter the number of items." << endl;
        cin >> m;

        cout << "\n__" << endl;
        switch (xx)
        {
        case 'A':
            d = m + (n * 5.50);
            cout << "Americano = RM" << fixed << setprecision(2) << d;
            break;
        case 'C':
            d = m + (n * 6.50);
            cout << "Chocolate = RM" << fixed << setprecision(2) << d;
            break;
        case 'L':
            d = m + (n * 6.50);
            cout << "Latte = RM" << fixed << setprecision(2) << d;
            break;
        case 'G':
            d = m + (n * 6.50);
            cout << "Green Tea Latte = RM" << fixed << setprecision(2) << d;
            break;
        }
    }
    else
    {
        cin.ignore();
    }

    cout << "\n__" << endl;
    cout << "Select your payment method. Card or Ewallet." << endl;
    cin >> y;

    if (y == Card)
    {
        cout << "Please tap your card for 5 seconds till it beeps.";
    }
    else
    {
        cout << "Please flash QR code for 5 seconds till it beeps.";
    }

    cout << "\n--------------------" << endl;
    cout << "\nPayment is complete. Enjoy your drink!" << endl;

    return 0;
}