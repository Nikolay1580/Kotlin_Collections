import org.jetbrains.academy.test.system.core.models.TestKotlinType
import org.jetbrains.academy.test.system.core.models.classes.TestClass
import org.jetbrains.academy.test.system.core.models.method.TestMethod

internal val generateListOfDucksMethod = TestMethod(
    "generateListOfDucks",
    returnType = TestKotlinType(
        "List",
        params = listOf("org.jetbrains.kotlin.course.duck.shop.duck.Duck"),
    ),
    returnTypeJava = "List",
)

internal val generateSetOfDucksMethod = TestMethod(
    "generateSetOfDucks",
    returnType = TestKotlinType(
        "Set",
        params = listOf("org.jetbrains.kotlin.course.duck.shop.duck.Duck"),
    ),
    returnTypeJava = "Set",
)

internal val generateMapOfDucksMethod = TestMethod(
    "generateMapOfDucks",
    returnType = TestKotlinType(
        "Map",
        params = listOf("org.jetbrains.kotlin.course.duck.shop.duck.Duck"),
    ),
    returnTypeJava = "Map",
)


internal val gameModeServiceTestClass = TestClass(
    "GameModeService",
    "org.jetbrains.kotlin.course.duck.shop.mode",
    customMethods = listOf(
        generateListOfDucksMethod,
        generateSetOfDucksMethod
    ),
)
