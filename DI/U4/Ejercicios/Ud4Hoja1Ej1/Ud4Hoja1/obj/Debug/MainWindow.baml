   M S B A M L   `   `   `  ����C  ?Ud4Hoja1, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null#clr-namespace:Ud4Hoja1Ud4Hoja1  5   	       Ud4Hoja1.MainWindow   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   (localclr-namespace:Ud4Hoja1     5   	     � Title$  Primeros pasos��5   	   $	��400��6    $	��350��6-   $	��400��69   $	��350��6I   .��5	      � .+�5
   
   �� $��Primer valor��6   $
��Left=�6'   $��	30,25,0,0q�6B   $	��Top=�6U   �� 5   
   $��Segundo valor��6   $
��Left=�6(   $��	30,75,0,0q�6C   $	��Top=�6V   �� 5   
   -   5         ��Name$ 
txtPrimero��5      $��30,50,200,0q�6&    �� TextWrapping$
 Wrap=�6;   $�� ��6O   $	��Top=�6W   �� 5   
   -   5        $ 
txtSegundo��5      $��30,100,200,0q�6&   $
 Wrap=�6<   $�� ��6P   $	��Top=�6X   �� 5   
   -   5         ��Name$ cmbOperacion��5      $��30,125,200,0q�6)   $	��Top=�6?   .@�5      �� 
 � Tag$ +��6   .��6#   Sumar6*   �� 5      $ -��6   .��6#   Restar6+   �� 5      $ *��6    �� 
IsSelected . .��65   Multiplicar6B   �� 5      $ /��6   .��6#   	Dividir6,   5      �� 5   
   -   5         ��Name$ btnCalcular��5      $��Calcular��6&    �� 	IsDefault . $��0,125,115,0q�6e   $	��Top=�6z    J� RenderTransformOrigin$ 
0.505,0.52&�6�   $��22��6�   $��Right=�6�   $��80��6�   �� 5   
   -   5        $ btnSalir��5      	 �� IsCancel	 . $��
0,125,30,0q�6J   $	��Top=�6^   $ 
0.505,0.52&�6v   $��22��6�   $��Right=�6�   $��80��6�   .��5      �� 
 �� Orientation$
 
Horizontal=�6   .+�5      �� $��Imagenes/cancelar.png��6   $��16��67   �� 5      $��Salir��6   5      5      �� 5   
   $��
Resultados��6   $
��Left=�6%   $��
30,150,0,0q�6@   $	��Top=�6T   �� 5   
   
���   �$��1q�6%   $��30,175,30,30q�69    �� Padding$ 5q�6O   ._�5      �� -   5         ��Name$ tbResultado��5      $
��Wrap=�6-   $�� ��6A   5      5!      5"      