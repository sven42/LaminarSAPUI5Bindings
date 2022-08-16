package be.doeraene.webcomponents.ui5

import be.doeraene.webcomponents.ui5.configkeys.*
import be.doeraene.webcomponents.ui5.internal.Slot
import com.raquo.domtypes.generic.codecs.{BooleanAsAttrPresenceCodec, StringAsIsCodec}
import com.raquo.laminar.api.L.*
import com.raquo.laminar.builders.HtmlTag
import com.raquo.laminar.keys.{ReactiveHtmlAttr, ReactiveProp, ReactiveStyle}
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import be.doeraene.webcomponents.WebComponent

/** A component that represents a logical step as part of the ui5-wizard. It is meant to aggregate arbitrary HTML
  * elements that form the content of a single step.
  *
  * @see
  *   <a href="https://sap.github.io/ui5-webcomponents/playground/components/Wizard/">the doc</a> for more information.
  */
object WizardStep extends WebComponent with HasIcon {

  @js.native
  trait RawElement extends js.Object {}

  type Ref         = dom.html.Element with RawElement
  type ModFunction = WizardStep.type => Mod[ReactiveHtmlElement[Ref]]

  private val tag: HtmlTag[Ref] = customHtmlTag("ui5-wizard-step")

  val branching: ReactiveHtmlAttr[Boolean] = customHtmlAttr("branching", BooleanAsAttrPresenceCodec)

  val disabled: ReactiveHtmlAttr[Boolean] = customHtmlAttr("disabled", BooleanAsAttrPresenceCodec)

  val selected: ReactiveHtmlAttr[Boolean] = customHtmlAttr("selected", BooleanAsAttrPresenceCodec)

  val subtitleText: ReactiveHtmlAttr[String] = customHtmlAttr("subtitle-text", StringAsIsCodec)

  val titleText: ReactiveHtmlAttr[String] = customHtmlAttr("title-text", StringAsIsCodec)

  object slots {}

  object events {}

  def apply(mods: ModFunction*): HtmlElement = tag(mods.map(_(WizardStep)): _*)

}
