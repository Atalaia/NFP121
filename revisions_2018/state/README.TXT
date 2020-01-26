#
verbose=true

bean.id.1=led
led.class=state.Lampe
led.property.1=etat
led.property.1.param.1=eteinte

bean.id.2=eteinte
eteinte.class=state.EtatEteint
eteinte.property.1=lampe
eteinte.property.1.param.1=led

