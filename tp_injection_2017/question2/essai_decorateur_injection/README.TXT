# trace destinée au femtoContainer
verbose=false

bean.id.1=nombre
nombre.class=question2.essai_decorateur_injection.Nombre
nombre.property.1=valeur
nombre.property.1.param.1=1

bean.id.2=toujoursVraie
toujoursVraie.class=question2.essai_decorateur_injection.ToujoursVraie

bean.id.3=nombreEstPositif
nombreEstPositif.class=question2.essai_decorateur_injection.NombreEstPositif

bean.id.4=operation1
operation1.class=question2.essai_decorateur_injection.NombreDeco
operation1.property.1=decore
operation1.property.1.param.1=identite
operation1.property.2=condition
operation1.property.2.param.1=toujoursVraie
#operation.property.2.param.1=nombrePositif
operation1.property.3=operation
operation1.property.3.param.1=plus1

bean.id.5=operation
operation.class=question2.essai_decorateur_injection.NombreDeco
operation.property.1=decore
operation.property.1.param.1=operation1
operation.property.2=condition
operation.property.2.param.1=toujoursVraie
#operation.property.2.param.1=nombrePositif
operation.property.3=operation
operation.property.3.param.1=plus1

bean.id.6=identite
identite.class=question2.essai_decorateur_injection.NombreIdentite

bean.id.7=plus1
plus1.class=question2.essai_decorateur_injection.NombrePlus1


