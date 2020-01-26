#verbose=true

bean.id.1=nombre1
nombre1.class=composant_logiciel.Nombre
nombre1.property.1=valeur
nombre1.property.1.param.1=1

bean.id.2=queue1
queue1.class=java.util.concurrent.SynchronousQueue

bean.id.3=queue2
queue2.class=java.util.concurrent.SynchronousQueue

bean.id.4=queue3
queue3.class=java.util.concurrent.SynchronousQueue

bean.id.5=queue4
queue4.class=java.util.concurrent.SynchronousQueue

bean.id.6=composant1
composant1.class=composant_logiciel.Composant
composant1.property.1=in
composant1.property.1.param.1=queue1
composant1.property.2=out
composant1.property.2.param.1=queue2
composant1.property.3=command
composant1.property.3.param.1=commandPlus10
composant1.property.4=exception
composant1.property.4.param.1=commandException

bean.id.7=composant2
composant2.class=composant_logiciel.Composant
composant2.property.1=in
composant2.property.1.param.1=queue2
composant2.property.2=out
composant2.property.2.param.1=queue3
composant2.property.3=command
#composant2.property.3.param.1=commandPlus1000
composant2.property.3.param.1=macroCommandPlus
composant2.property.4=exception
composant2.property.4.param.1=commandException

bean.id.8=composant3
composant3.class=composant_logiciel.Composant
composant3.property.1=in
composant3.property.1.param.1=queue3
composant3.property.2=out
composant3.property.2.param.1=queue4
composant3.property.3=command
composant3.property.3.param.1=trace
composant3.property.4=exception
composant3.property.4.param.1=commandException

bean.id.9=commandPlus10
commandPlus10.class=composant_logiciel.CommandeNombrePlus
commandPlus10.property.1=operande
commandPlus10.property.1.param.1=10

bean.id.10=trace
trace.class=composant_logiciel.Trace

bean.id.11=macroCommandPlus
macroCommandPlus.class=composant_logiciel.MacroCommand
macroCommandPlus.property.1=commands
macroCommandPlus.property.1.param.1=commandPlus10 commandPlus10 commandPlus10 commandPlus10

bean.id.12=commandException
commandException.class=composant_logiciel.CommandeException

bean.id.13=composant1_variabilite
composant1_variabilite.class=composant_logiciel.Composant
composant1_variabilite.property.1=in
composant1_variabilite.property.1.param.1=queue1
composant1_variabilite.property.2=out
composant1_variabilite.property.2.param.1=queue2
composant1_variabilite.property.3=command
composant1_variabilite.property.3.param.1=commandPlus1000
composant1_variabilite.property.4=exception
composant1_variabilite.property.4.param.1=commandException

bean.id.14=commandPlus1000
commandPlus1000.class=composant_logiciel.CommandeNombrePlus
commandPlus1000.property.1=operande
commandPlus1000.property.1.param.1=1000


bean.id.15=trois_composants
trois_composants.class=composant_logiciel.Composants
trois_composants.property.1=composants
trois_composants.property.1.param.1=composant1 composant2 composant3

