import control as ctl
import matplotlib.pyplot as plt


# Funcao de transferencia H( s ) e Omega = 119 kHz

Omega = 119

H = ctl.tf([10],[1/(Omega/10),1])

# Traca o diagrama de bode de H(s)

ctl.bode (H, dB=True)

# Plota o grafico

plt.show()
