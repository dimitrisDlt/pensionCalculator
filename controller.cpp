#include "controller.h"
#include <iostream>

controller::controller(QObject *parent) {}

void controller::onButtonClicked()
{
    std::cout << "Hello" << std::endl;
}
