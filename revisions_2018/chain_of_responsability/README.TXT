
#verbose=true

bean.id.1=invoker
invoker.class=chain_of_responsability.Invoker
invoker.property.1=handlers
invoker.property.1.param.1=plus10

bean.id.2=nombre1
nombre1.class=chain_of_responsability.Nombre
nombre1.property.1=valeur
nombre1.property.1.param.1=1

bean.id.3=plus10
plus10.class=chain_of_responsability.Plus
plus10.property.1=successor
plus10.property.1.param.1=plus10_b
plus10.property.2=max
plus10.property.2.param.1=20
plus10.property.3=operande
plus10.property.3.param.1=10

bean.id.4=plus10_b
plus10_b.class=chain_of_responsability.Plus
plus10_b.property.1=successor
plus10_b.property.1.param.1=null
plus10_b.property.2=max
plus10_b.property.2.param.1=20
plus10_b.property.3=operande
plus10_b.property.3.param.1=6


