package com.omurkmr.githubrepo.extentions

import org.koin.core.context.GlobalContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier


    /**
     * inject lazily given dependency for Android koincomponent
     * @param qualifier - bean qualifier / optional
     * @param parameters - injection parameters
     */
    inline fun <reified T : Any> Any.inject(
        qualifier: Qualifier? = null,
        noinline parameters: ParametersDefinition? = null
    ) = lazy { GlobalContext.get().koin.get<T>(qualifier, parameters) }
