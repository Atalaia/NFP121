#verbose=true

bean.id.1=nombre1
nombre1.class=observer.Nombre
nombre1.property.1=valeur
nombre1.property.1.param.1=1
nombre1.property.2=observer
nombre1.property.2.param.1=observateur1
nombre1.property.3=observer
nombre1.property.3.param.1=observateur2

bean.id.2=observateur1
observateur1.class=observer.NombreObserver
observateur1.property.1=nom
observateur1.property.1.param.1=obs_1

bean.id.3=observateur2
observateur2.class=observer.NombreObserver
observateur2.property.1=nom
observateur2.property.1.param.1=obs_2

bean.id.4=conditionEstPair
conditionEstPair.class=observer.ConditionEstPair

bean.id.5=operationPlus1
operationPlus1.class=observer.OperationPlus
operationPlus1.property.1=operande
operationPlus1.property.1.param.1=1

# commande plus1 si pair
bean.id.6=commandePlus1
commandePlus1.class=observer.CommandNombre
commandePlus1.property.1=operation
commandePlus1.property.1.param.1=operationPlus1
commandePlus1.property.2=condition
commandePlus1.property.2.param.1=conditionEstPair

bean.id.7=macroPlus
macroPlus.class=commands.MacroCommand
macroPlus.property.1=commands
macroPlus.property.1.param.1=plus plus plus plus plus
macroPlus.property.2=condition
macroPlus.property.2.param.1=toujoursVrai


# commande plus1 sans condition
bean.id.8=plus
plus.class=observer.CommandNombre
plus.property.1=operation
plus.property.1.param.1=operationPlus1
plus.property.2=condition
plus.property.2.param.1=toujoursVrai


bean.id.9=toujoursVrai
toujoursVrai.class=conditions.VRAI

# commande plus2 sans condition
bean.id.10=plus2
plus2.class=observer.CommandNombre
plus2.property.1=operation
plus2.property.1.param.1=operationPlus2
plus2.property.2=condition
plus2.property.2.param.1=toujoursVrai

bean.id.11=operationPlus2
operationPlus2.class=observer.OperationPlus
operationPlus2.property.1=operande
operationPlus2.property.1.param.1=2

bean.id.12=macroPlusPlus
macroPlusPlus.class=commands.MacroCommand
macroPlusPlus.property.1=commands
macroPlusPlus.property.1.param.1=plus2 plus2 plus2 plus plus plus
macroPlusPlus.property.2=condition
macroPlusPlus.property.2.param.1=toujoursVrai

bean.id.13=invoker
invoker.class=commands.Invoker
invoker.property.1=command
invoker.property.1.param.1=macroPlusPlus
#invoker.property.1.param.1=macroPlusPlusPeutEtre
invoker.property.2=exception
invoker.property.2.param.1=invokerException

bean.id.14=invokerException
invokerException.class=observer.InvokerException
invokerException.property.1=resultat
invokerException.property.1.param.1=resultatException
invokerException.property.2=runtimeException
invokerException.property.2.param.1=runtimeException
#invokerException.property.2=operation
#invokerException.property.2.param.1=nop
#invokerException.property.3=condition
#invokerException.property.3.param.1=toujoursVrai
#invokerException.property.4=exception
#invokerException.property.4.param.1=nop


bean.id.15=resultatException
resultatException.class=observer.Resultat
resultatException.property.1=valeur
resultatException.property.1.param.1=-1

bean.id.16=nombre1000
nombre1000.class=observer.Nombre
nombre1000.property.1=valeur
nombre1000.property.1.param.1=1000

bean.id.17=nop
nop.class=operations.NOP

bean.id.18=runtimeException
runtimeException.class=java.lang.RuntimeException

bean.id.19=peut_etre
peut_etre.class=conditions.PEUT_ETRE

bean.id.20=macroPlusPlusPeutEtre
macroPlusPlusPeutEtre.class=commands.MacroCommand
macroPlusPlusPeutEtre.property.1=commands
macroPlusPlusPeutEtre.property.1.param.1=plus2b plus2b plus2b
macroPlusPlusPeutEtre.property.2=condition
#macroPlusPlusPeutEtre.property.2.param.1=peut_etre
macroPlusPlusPeutEtre.property.2.param.1=toujoursVrai

bean.id.21=invokerPeutEtre
invokerPeutEtre.class=commands.Invoker
invokerPeutEtre.property.1=command
invokerPeutEtre.property.1.param.1=macroPlusPlusPeutEtre

# commande plus2 peut-etre
bean.id.22=plus2b
plus2b.class=observer.CommandNombre
plus2b.property.1=operation
plus2b.property.1.param.1=operationPlus2
plus2b.property.2=condition
plus2b.property.2.param.1=peut_etre
